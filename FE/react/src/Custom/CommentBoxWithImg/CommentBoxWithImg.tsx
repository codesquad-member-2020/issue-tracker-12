/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import { useState } from 'react';
import Flex from '@Custom/Flex/Flex';
import CommentBox from '@Custom/CommentBox/CommentBox';

/**
 * 프로젝트 내에서 댓글 컴포넌트를 활용해야할 때,  CommentBoxWithImg 컴포넌트를 사용하세요.
 */

const CommentBoxWithImg = () => {
  return (
    <Flex align="left" width="100%" gap="1rem">
      <div>
        <img css={imgStyle} src="https://pbs.twimg.com/media/EAfNcH2UwAMGbx6?format=jpg&name=small"></img>
      </div>
      <CommentBox />
    </Flex>
  );
};

const imgStyle = css`
  height: auto;
  max-width: 50px;
  width: auto;
`;

export default CommentBoxWithImg;
