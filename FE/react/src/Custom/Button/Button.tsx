/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { ReactNode } from 'react';

export type ButtonProps = {
  /** 렌더링할 대상 */
  children: ReactNode;
  /** 버튼의 전체적인 테마를 정한다 */
  theme: 'primary' | 'secondary' | 'nooutline' | 'subtle' | 'nocolor';
  /** 글자 크기를 조절한다 */
  fontSize: 'small' | 'medium' | 'big';
  /** 넓이를 조절할 수 있다 */
  width: string | number;
  /** 클릭할 수 없게 만든다 */
  disabled?: boolean;
  /** 클릭용 콜백함수를 등록한다 */
  onClick?: () => void;
};

/**
 * 프로젝트 내에서 버튼 모양의 컴포넌트를 활용해야할 때, Button 컴포넌트를 사용하세요.
 *
 * - `width` 값에 ```15px``` 혹은 ```10%```로 직접 설정할 수 있습니다. 숫자를 넣으면, 숫자는 px단위로 계산해서 Button의 크기가 정해집니다.
 * - disabled prop에 true를 넘겨주면, Button 컴포넌트는 **비활성화**됩니다.
 */

const Button = ({ children, theme, fontSize, width, disabled, onClick }: ButtonProps) => {
  return (
    <button css={[style, themes[theme], fontSizes[fontSize], { width }]} disabled={disabled} onClick={onClick}>
      {children}
    </button>
  );
};

const style = css`
  outline: none;
  border: none;
  box-sizing: border-box;
  padding: 0.5rem 0;
  border-radius: 0.25rem;
  font-weight: bold;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  color: #ffffff;
  height: 100%;
  cursor: pointer;
  &:disabled {
    cursor: not-allowed;
    opacity: 0.4;
  }
`;

const themes = {
  primary: css`
    background: #2dc250;
    &:hover:enabled {
      background: #cc373c;
    }
  `,
  secondary: css`
    background: #cb2431;
    &:hover:enabled {
      background: #7b7b7b;
    }
  `,
  nocolor: css`
    background: #ebeff3;
    color: #000000;
    &:hover:enabled {
      background: #b9bdd1;
    }
  `,

  nooutline: css`
    background: none;
    color: #484848;
    justify-content: flex-start;
    text-decoration: underline;
    &:hover:enabled {
      color: #7b7b7b;
    }
  `,
  subtle: css`
    background: #ffffff;
    border-color: #999999;
    color: #4b4b4b;
    svg {
      fill: #999999;
    }
    &:disabled {
      color: #cccccc;
      svg {
        fill: #cccccc;
      }
    }
  `
};

const fontSizes = {
  small: css`
    font-size: 0.45rem;
  `,
  medium: css`
    font-size: 0.75rem;
  `,
  big: css`
    font-size: 1.15rem;
  `
};

Button.defaultProps = {
  theme: 'primary',
  fontSize: 'medium',
  width: '100%',
  disabled: false
};

export default Button;
