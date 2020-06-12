/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useState, KeyboardEvent } from 'react';
import Flex from '@Custom/Flex/Flex';

type TagsInputProp = {
  /** 미리 보여줄 태그들을 명시합니다 */
  tags: string[];
};

/**
 * 프로젝트 내에서 태그 관련 필터링을 할 때 쓸 수 있는 컴포넌트입니다.
 * 이 컴포넌트를 이용하여, 사용자가 입력하는 태그를 추가할 수 있습니다.
 */

const TagsInput = ({ tags }: TagsInputProp) => {
  const [tagArray, setTagArray] = useState(tags);

  const addTags = (event: KeyboardEvent<HTMLInputElement>) => {
    const { value } = event.currentTarget;
    if (value !== '') {
      setTagArray([...tagArray, value]);
      event.currentTarget.value = '';
    }
  };
  return (
    <Flex align="left" alignItemCenter={true} customCSS={tagsInputStyle}>
      <ul css={tagsStyle}>
        {tagArray.map((tag, index) => (
          <li key={index} css={liStyle}>
            <span>{tag}</span>
          </li>
        ))}
      </ul>
      <input
        type="text"
        onKeyUp={event => (event.key === 'Enter' ? addTags(event) : null)}
        placeholder="Press enter to add filter"
        css={inputStyle}
      />
    </Flex>
  );
};

const tagsInputStyle = css`
  border: 1px solid #000000;
  box-sizing: border-box;
  height: 31px;
  min-width: 500px;
  max-width: 500px;
  padding: 0.3rem;
`;

const tagsStyle = css`
  margin: 0;
  padding: 0;
  > * {
    list-style: none;
    margin-right: 0.35rem;
  }
`;

const liStyle = css`
  display: inline-block;
  font-size: 0.9rem;
`;

const inputStyle = css`
  appearance: none;
  border: none;
  outline: none;
  margin-top: 0.1rem;
`;

export default TagsInput;
