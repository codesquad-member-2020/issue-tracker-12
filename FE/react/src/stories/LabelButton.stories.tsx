import React from 'react';
import LabelButton from '@Custom/LabelButton/LabelButton';
import { withKnobs, text, select } from '@storybook/addon-knobs';

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

export const labelButton = () => {
  const iconType = select(
    'direction',
    ['task', 'arrow', 'check', 'close', 'exclamation', 'github', 'option', 'tag'],
    'task'
  );
  const label = text('label', 'filters');
  return <LabelButton iconType={iconType} label={label} />;
};

labelButton.story = {
  name: 'Default'
};
