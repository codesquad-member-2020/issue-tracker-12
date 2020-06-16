import React from 'react';
import CommentBoxWithImg from '@Custom/CommentBoxWithImg/CommentBoxWithImg';
import { withKnobs, text, boolean, select } from '@storybook/addon-knobs';

export default {
  title: 'components|CommentBoxWithImg',
  component: CommentBoxWithImg,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 댓글 창 컴포넌트'
  }
};

export const primary = () => {
  return <CommentBoxWithImg></CommentBoxWithImg>;
};
