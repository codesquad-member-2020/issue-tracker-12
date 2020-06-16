/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useState, KeyboardEvent } from 'react';
import Flex from '@Custom/Flex/Flex';
import Icon from '@Icon/Icon';

type InputProp = {
  /** 미리 보여줄 태그들을 명시합니다 */
  initalValue: string;
  /** Input의 길이를 정할 수 있습니다 */
  width: string | number;
};

/**
 * 프로젝트 내에서 필터링 검색을 할 때 쓸 수 있는 컴포넌트입니다.
 */

const ENTER = 13;

const Input = ({ initalValue, width }: InputProp) => {
  const [contents, setContents] = useState(initalValue);
  const handleInput = (e: React.FormEvent<HTMLInputElement>) => {
    const { value } = e.currentTarget;
    const newValue = value + '';
    setContents(newValue);
  };

  const handleKeyUp = (e: KeyboardEvent<HTMLInputElement>) => {
    const { value } = e.currentTarget;
    if (e.keyCode === ENTER) {
      console.log('hello');
    }
  };

  return (
    <Flex align="left" width={width} alignItemCenter={true} customCSS={wrapperStyle}>
      <div css={iconStyle}>
        <Icon icon="magnifier" size={'15px'} />
      </div>
      <input
        value={contents}
        onKeyUp={handleKeyUp}
        onChange={handleInput}
        css={inputStyle}
        placeholder={'Search all issues'}></input>
    </Flex>
  );
};

Input.defaultProps = {
  width: '100%'
};

const wrapperStyle = css`
  border: 1px solid #c1c5c7;
  border-radius: 0.25rem;
  box-sizing: border-box;
  height: 31px;
  padding: 0.2rem;
  position: relative;
`;

const iconStyle = css`
  position: absolute;
`;

const inputStyle = css`
  width: 97%;
  box-sizing: border-box;
  left: 0.9rem;
  position: relative;
  outline: none;
  border: none;
  appearance: none;
`;

export default Input;
