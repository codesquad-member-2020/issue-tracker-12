import React from 'react';
import TagsInput from '@Custom/TagsInput/TagsInput';
import { withKnobs, text, boolean, select } from '@storybook/addon-knobs';

export default {
  title: 'components|TagsInput',
  component: TagsInput,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 TagsInput 컴포넌트'
  }
};

const exampleProp = ['hera', 'supplement', 'facts'];

export const example = () => {
  return <TagsInput tags={exampleProp} />;
};
