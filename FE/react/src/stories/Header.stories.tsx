import React from 'react';
import Header from '@Components/Header/Header';
import { withKnobs } from '@storybook/addon-knobs';

export default {
  title: 'components|Header',
  component: Header,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 헤더 컴포넌트'
  }
};

export const example = () => {
  return <Header />;
};
