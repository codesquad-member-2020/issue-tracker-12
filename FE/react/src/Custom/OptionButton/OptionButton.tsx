/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useRef, useState } from 'react';
import useFocusOut from '@Util/customHooks/useFocusOut';
import Icon from '@Icon/Icon';
import Flex from '@Custom/Flex/Flex';

type OptionButtonProp = {
  /** 필터할 대상(카테고리)를 적어줍니다 */
  category: string;
  /** 필터링 버튼의 가로 크기를 정합니다 */
  width?: number | string;
  /** 선택창의 주제를 정할 수 있습니다 */
  subject: string;
  /** 선택창의 필터링 기준을 나열할 수 있습니다 */
  filters: string[];
  /** 선택창의 가로 넓이를 정할 수 있습니다 */
  contentsBoxSize: number | string;
};

/**
 * 프로젝트 내에서 필터링 버튼 컴포넌트를 활용해야할 때, OptionButton 컴포넌트를 사용하세요.
 *
 * - 내부적으로 Button 컴포넌트를 활용합니다. theme와 fontSize를 통해 Button의 테마와 글자 크기를 설정합니다.
 */

const OptionButton = ({ category, subject, filters, width, contentsBoxSize }: OptionButtonProp) => {
  const wrapperRef = useRef<HTMLDivElement>(null);
  const [focus, setFocus] = useState(false);
  useFocusOut(wrapperRef, setFocus);
  return (
    <div css={[styled, { width }]}>
      <Flex alignItemCenter={true} width={'100%'} align="spaceBetween">
        <p css={bold}>{category}</p>
        <Icon icon="option" size={'15px'} onClick={() => setFocus(true)} />
      </Flex>
      {focus && (
        <div css={[contentsStyle, { width: contentsBoxSize }]} ref={wrapperRef}>
          <div css={subjectStyle}>{subject}</div>
          <Flex direction="column" customCSS={borderTopWithChild}>
            {filters.map(filter => (
              <div css={filterStyle} key={filter}>
                filter
              </div>
            ))}
          </Flex>
        </div>
      )}
    </div>
  );
};

OptionButton.defaultProps = {
  theme: 'nocolor',
  fontSize: 'medium'
};

const styled = css`
  position: relative;
  width: 100%;
`;

const bold = css`
  font-weight: 900;
  margin-right: 0.3rem;
`;

const contentsStyle = css`
  width: 200px;
  background-color: #ffffff;
  border: 1px solid #eeeeee;
  position: absolute;
  top: calc(100% + 10px);
  right: 0;
  box-shadow: 0px 0px 10px rgba(173, 173, 173, 0.3);
`;

const subjectStyle = css`
  background-color: #eeeeee;
  padding: 0.5rem 0.5rem;
`;

const filterStyle = css`
  padding: 0.5rem 0.5rem;
`;

const borderTopWithChild = css({
  '> *': {
    'border-top': '1px solid #000000'
  }
});

export default OptionButton;
