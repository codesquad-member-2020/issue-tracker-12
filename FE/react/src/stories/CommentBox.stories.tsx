import React from 'react';
import CommentBox from '@Custom/CommentBox/CommentBox';
import { withKnobs, text, boolean, select } from '@storybook/addon-knobs';
import Icon from '@Icon/Icon';
import { action } from '@storybook/addon-actions';

export default {
  title: 'components|CommentBox',
  component: CommentBox,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 버튼 컴포넌트'
  }
};

export const primary = () => {
  return <CommentBox></CommentBox>;
};
