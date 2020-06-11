/** @jsx jsx */
import { jsx, css, SerializedStyles } from '@emotion/core';
import { ReactNode } from 'react';

type Align = 'left' | 'right' | 'spaceAround' | 'spaceBetween';
type Direction = 'column' | 'row';

export type FlexProps = {
  /** Flex의 대상이 되는 Node입니다 */
  children: ReactNode;
  /** Flex의 방향을 정합니다 */
  direction: Direction;
  /** Flex가 적용되는 기준점을, 기준축 기준으로 정합니다 */
  align: Align;
  /** Flex가 wrap이 되는지 여부를 정합니다 */
  wrap?: boolean;
  /** Flex의 대상이 되는 Node 사이 Gap을 정합니다 */
  gap?: number | string;
  /** Flex가 차지하는 가로 넓이를 정합니다 */
  width?: string | number;
  /** 기준축이 아닌 축을 기준으로 중앙으로 정렬합니다 */
  alignItemCenter?: boolean;
  /** Custom으로 CSS를 설정할 수 있습니다 */
  customCSS?: SerializedStyles;
};

/**
 * 프로젝트 내에서 레이아웃을 잡을 때, 활용할 수 있는 컴포넌트입니다.
 *
 * - direction을 통해서, flex의 방향을 결정할 수 있습니다.
 * - customCSS을 통해서, Flex에 추가적인 CSS 설정을 할 수 있습니다.
 */

const Flex = ({ children, direction, wrap, align, gap, width, alignItemCenter, customCSS }: FlexProps) => {
  const cssArray = [
    style,
    alignItemCenterStyle(alignItemCenter),
    directionStyle(direction),
    gapStyle(direction, gap),
    alignStyle(align),
    wrapStyle(wrap),
    { width }
  ];
  customCSS && cssArray.push(customCSS);
  return <div css={cssArray}>{children}</div>;
};

export default Flex;

Flex.defaultProps = {
  direction: 'row',
  align: 'spaceBetween'
};

const style = css`
  display: flex;
`;

const alignItemCenterStyle = (alignItemCenter: boolean | undefined) => {
  if (!alignItemCenter) {
    return css``;
  }
  return css`
    align-items: center;
  `;
};

const directionStyle = (direction: Direction) => {
  return css`
    flex-direction: ${direction};
  `;
};

const getAlignStyleName = (align: Align) => {
  switch (align) {
    case 'right':
      return 'flex-end';
    case 'left':
      return 'flex-start';
    case 'spaceAround':
      return 'space-around';
    default:
      return 'space-between';
  }
};

const alignStyle = (align: Align) => {
  return css`
    justify-content: ${getAlignStyleName(align)};
  `;
};

const wrapStyle = (wrap: boolean | undefined) => {
  if (wrap) {
    return css`
      flex-wrap: wrap;
    `;
  }
  return css``;
};

const gapStyle = (direction: Direction, gap: number | string | undefined) => {
  if (!gap) {
    return css``;
  }
  const marginType = direction === 'row' ? 'marginLeft' : 'marginTop';
  return css({
    '> *:not(:first-child)': {
      [marginType]: gap
    }
  });
};
