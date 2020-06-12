import React from 'react';
import Tab from '@Custom/Tab/Tab';
import { withKnobs, text } from '@storybook/addon-knobs';

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

export const tab = () => {
  const contentsHeight = text('contentsHeight', '200px');
  const contentsWidth = text('contentsWidth', '500px');
  return <Tab tabs={['Write', 'Preview']} contentsWidth={contentsWidth} contentsHeight={contentsHeight} />;
};

tab.story = {
  name: 'Default'
};
