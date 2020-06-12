/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useRef, useState, ReactNode } from 'react';
import useFocusOut from '@Util/customHooks/useFocusOut';
import Icon from '@Icon/Icon';
import Flex from '@Custom/Flex/Flex';
import Button, { ButtonFontSize, ButtonTheme } from '@Custom/Button/Button';

type FilterButtonProp = {
  /** 필터할 대상(카테고리)를 적어줍니다 */
  category: string;
  /** 필터링 버튼의 테마를 정합니다 */
  theme: ButtonTheme;
  /** 필터링 버튼의 글자 크기를 정합니다 */
  fontSize: ButtonFontSize;
  /** 필터링 버튼의 가로 크기를 정합니다 */
  width?: string;
  /** 선택창의 주제를 정할 수 있습니다 */
  subject: string;
  /** 선택창의 필터링 기준을 나열할 수 있습니다 */
  filters: string[];
  /** 선택창의 가로 넓이를 정할 수 있습니다 */
  contentsBoxSize: number | string;
};

/**
 * 프로젝트 내에서 필터링 버튼 컴포넌트를 활용해야할 때, FilterButton 컴포넌트를 사용하세요.
 *
 * - 내부적으로 Button 컴포넌트를 활용합니다. theme와 fontSize를 통해 Button의 테마와 글자 크기를 설정합니다.
 */

const FilterButton = ({ category, theme, fontSize, subject, filters, width, contentsBoxSize }: FilterButtonProp) => {
  const wrapperRef = useRef<HTMLDivElement>(null);
  const [focus, setFocus] = useState(false);
  useFocusOut(wrapperRef, setFocus);
  return (
    <div css={[styled, { width }]}>
      <Button theme={theme} fontSize={fontSize} onClick={() => setFocus(true)} noPadding={true}>
        <Flex alignItemCenter={true}>
          <p css={bold}>{category}</p>
          <Icon icon="arrow" size={'15px'} />
        </Flex>
      </Button>
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

FilterButton.defaultProps = {
  theme: 'nocolor',
  fontSize: 'medium'
};

const styled = css`
  box-sizing: border-box;
  border: 1px solid #000000;
  height: 31px;
  position: relative;
`;

const bold = css`
  font-weight: 900;
  margin-right: 0.3rem;
`;

const contentsStyle = css`
  background-color: #ffffff;
  border: 1px solid #eeeeee;
  box-shadow: 0px 0px 10px rgba(173, 173, 173, 0.3);
  position: absolute;
  top: calc(100% + 10px);
  width: 400px;
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
    borderTop: '1px solid #000000'
  }
});

export default FilterButton;
