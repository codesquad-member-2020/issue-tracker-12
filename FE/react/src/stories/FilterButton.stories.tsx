import React from 'react';
import FilterButton from '@Custom/FilterButton/FilterButton';
import { withKnobs, text, boolean, select } from '@storybook/addon-knobs';
import { action } from '@storybook/addon-actions';

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

export const filterButton = () => {
  return <FilterButton category="Author" subject="Filter Issues" filters={exampleFilters}></FilterButton>;
};
