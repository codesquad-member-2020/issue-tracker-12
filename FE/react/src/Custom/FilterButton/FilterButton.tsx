/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useRef, useState, ReactNode, SFC } from 'react';
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
};

const FilterButton = ({ category, theme, fontSize, subject, filters }: FilterButtonProp) => {
  const wrapperRef = useRef<HTMLDivElement>(null);
  const [focus, setFocus] = useState(false);
  useFocusOut(wrapperRef, setFocus);
  return (
    <div css={styled}>
      <Button theme={theme} fontSize={fontSize} onClick={() => setFocus(true)} noPadding={true}>
        <Flex alignItemCenter={true}>
          <p>{category}</p>
          <Icon icon="arrow" size={'20px'} />
        </Flex>
      </Button>
      {focus && (
        <div css={contentsStyle} ref={wrapperRef}>
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
  position: relative;
`;

const contentsStyle = css`
  width: 400px;
  background-color: #ffffff;
  border: 1px solid #eeeeee;
  position: absolute;
  top: calc(100% + 10px);
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

export default FilterButton;
