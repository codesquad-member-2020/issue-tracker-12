import React from 'react';
import Tab from '@Custom/Tab/Tab';
import { withKnobs, text, select } from '@storybook/addon-knobs';

export default {
  title: 'components|Tab',
  component: Tab,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 탭 컴포넌트'
  }
};

export const example = () => {
  return <Tab tabs={['Write', 'Preview']} contentsHeight={'200px'} contentsWidth={'500px'} />;
};
