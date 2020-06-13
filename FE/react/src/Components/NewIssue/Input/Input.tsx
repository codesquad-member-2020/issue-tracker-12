/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useState, ChangeEvent } from 'react';

const Input = () => {
  const [text, setText] = useState('');
  const onChangeHandler = (e: ChangeEvent<HTMLInputElement>) => {
    const { value } = e.currentTarget;
    setText(value);
  };

  return <input css={inputStyle} value={text} onChange={onChangeHandler}></input>;
};

const inputStyle = css`
  box-sizing: border-box;
  height: 31px;
  padding: 0;
  width: 100%;
`;

export default Input;
