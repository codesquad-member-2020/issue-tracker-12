/** @jsx jsx */
import { jsx, css } from '@emotion/core';

type LabelProp = {
  /** 레이블에 들어갈 내용을 명시합니다 */
  contents: string;
  /** 레이블의 배경색을 정합니다 */
  color: string;
};

/**
 * 프로젝트 내에서 레이블을 이용해야할 때, Label 컴포넌트를 사용하세요.
 * Button 컴포넌트와 Label 컴포넌트는 **용도가** 다른 컴포넌트입니다.
 *
 */

const pickTextColorBasedOnBgColor = (bgColor: string) => {
  const color = bgColor.charAt(0) === '#' ? bgColor.substring(1, 7) : bgColor;
  const r = parseInt(color.substring(0, 2), 16);
  const g = parseInt(color.substring(2, 4), 16);
  const b = parseInt(color.substring(4, 6), 16);
  return r * 0.299 + g * 0.587 + b * 0.114 > 186 ? '#ffffff' : '#000000';
};

const Label = ({ contents, color }: LabelProp) => {
  return (
    <div css={[labelStyle(color), { backgroundColor: color, color: pickTextColorBasedOnBgColor(color) }]}>
      {contents}
    </div>
  );
};

const labelStyle = (color: string) => css`
  border: 1px solid ${color};
  box-sizing: border-box;
  font-size: 0.75rem;
  font-weight: 600;
  padding: 0.1rem 0.3rem;
`;

export default Label;
