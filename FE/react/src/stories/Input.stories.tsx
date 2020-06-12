import React from 'react';
import { withKnobs } from '@storybook/addon-knobs';
import Input from '@Custom/Input/Input';

export default {
  title: 'components|Input',
  component: Input,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 Input 컴포넌트'
  }
};

const exampleProp = ['hera', 'supplement', 'facts'];

export const example = () => {
  return <Input tags={exampleProp} />;
};
