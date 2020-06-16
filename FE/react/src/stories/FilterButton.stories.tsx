import React from 'react';
import FilterButton from '@Custom/FilterButton/FilterButton';
import { withKnobs, text, select } from '@storybook/addon-knobs';

export default {
  title: 'components|FilterButton',
  component: FilterButton,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 필터링 버튼 컴포넌트'
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
    <FilterButton
      category="Author"
      subject="Filter Issues"
      filters={exampleFilters}
      contentsBoxSize={'100%'}></FilterButton>
  );
};

export const filterButton = () => {
  const category = text('category', 'Author');
  const contentsBoxSize = text('width', '100%');
  const fontSize = select('fontSize', ['small', 'medium', 'big'], 'medium');
  const subject = text('subject', 'Filter Issues');
  const theme = select('theme', ['primary', 'secondary', 'nooutline', 'nocolor', 'subtle'], 'primary');
  const width = text('width', '100%');

  return (
    <FilterButton
      category={category}
      contentsBoxSize={contentsBoxSize}
      subject={subject}
      fontSize={fontSize}
      theme={theme}
      width={width}
      filters={exampleFilters}></FilterButton>
  );
};

filterButton.story = {
  name: 'Default'
};
