/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useState } from 'react';
import Flex from '@Custom/Flex/Flex';
import ReactMarkdown from 'react-markdown';
import Button from '@Custom/Button/Button';

/**
 * 프로젝트 내에서 댓글 컴포넌트를 활용해야할 때, CommentBox 컴포넌트를 사용하세요.
 */

const CommentBox = () => {
  const [inputText, setInputText] = useState('');
  const [isEdit, setIsEdit] = useState(false);

  return (
    <Flex direction="column">
      <div css={headerStyle}>
        <Flex alignItemCenter={true} customCSS={headerCustomStyle}>
          <Flex alignItemCenter={true} gap={10}>
            <p css={idStyle}>sejungkim</p>
            <div css={dateStyle}>April 1, 2024</div>
          </Flex>
          <Flex align="right" alignItemCenter={true} customCSS={alignItemsBaseline} gap={10}>
            <div css={memberStyle}>Member</div>
            <Button theme="nooutline" noPadding={true} onClick={() => setIsEdit(true)}>
              Edit
            </Button>
          </Flex>
        </Flex>
      </div>
      {isEdit ? (
        <textarea
          css={bodyStyle}
          value={inputText}
          onInput={(e: React.FormEvent<HTMLTextAreaElement>) => {
            setInputText(e.currentTarget.value);
          }}></textarea>
      ) : (
        <div css={bodyStyle}>
          <ReactMarkdown source={inputText} />
        </div>
      )}
      {isEdit && (
        <Flex align="right" gap={10}>
          <Button theme="secondary" onClick={() => setIsEdit(false)} width="5%">
            cancel
          </Button>
          <Button onClick={() => setIsEdit(false)} width="5%">
            save
          </Button>
        </Flex>
      )}
    </Flex>
  );
};

const idStyle = css`
  font-weight: 900;
  font-size: 0.9rem;
`;

const headerCustomStyle = css`
  padding: 0.5rem;
  box-sizing: border-box;
`;

const dateStyle = css`
  font-size: 0.9rem;
`;

const alignItemsBaseline = css`
  align-items: baseline;
`;

const headerStyle = css`
  border: 1px solid #b0b7bb;
  background-color: #f1f8ff;
  box-sizing: border-box;
`;

const bodyStyle = css`
  box-sizing: border-box;
  border: 1px solid #b0b7bb;
  min-height: 100px;
`;

const memberStyle = css`
  font-size: 0.75rem;
  background-color: #f1f8ff;
  color: #5d6069;
  font-weight: 900;
  padding: 0.5rem;
  border: 1px solid #b0b7bb;
`;

export default CommentBox;
