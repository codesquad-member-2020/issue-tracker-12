import React from 'react';
import OptionButton from '@Custom/OptionButton/OptionButton';
import { withKnobs, text, select } from '@storybook/addon-knobs';

export default {
  title: 'components|OptionButton',
  component: OptionButton,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 옵션 버튼 컴포넌트'
  }
};

const exampleFilters = [
  'Open Issues',
  'Your Issues',
  'Everything assigned to you',
  'Everything mentioning you',
  'Closed Issues'
];

export const example = () => {
  return (
    <div style={{ width: '500px' }}>
      <OptionButton
        contentsBoxSize={'100%'}
        category="Author"
        subject="Filter Issues"
        width={'100%'}
        filters={exampleFilters}
      />
    </div>
  );
};

export const optionButton = () => {
  const category = text('category', 'Author');
  const contentsBoxSize = text('width', '100%');
  const fontSize = select('fontSize', ['small', 'medium', 'big'], 'medium');
  const subject = text('subject', 'Filter Issues');
  const theme = select('theme', ['primary', 'secondary', 'nooutline', 'nocolor', 'subtle'], 'primary');
  const width = text('width', '100%');

  return (
    <OptionButton
      category={category}
      contentsBoxSize={contentsBoxSize}
      subject={subject}
      fontSize={fontSize}
      theme={theme}
      width={width}
      filters={exampleFilters}
    />
  );
};

optionButton.story = {
  name: 'Default'
};
