import React from 'react';
import LabelButton from '@Custom/LabelButton/LabelButton';
import { withKnobs, text, boolean, select } from '@storybook/addon-knobs';

export default {
  title: 'components|LabelButton',
  component: LabelButton,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 레이블 버튼 컴포넌트'
  }
};

export const example = () => {
  return <LabelButton iconType="task" label="filters" />;
};
