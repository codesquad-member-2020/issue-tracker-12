import React from 'react';
import Flex from '@Custom/Flex/Flex';
import { withKnobs, text, boolean, select } from '@storybook/addon-knobs';

export default {
  title: 'components|Flex',
  component: Flex,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 스타일링 컴포넌트'
  }
};

export const example = () => {
  return (
    <Flex gap={10}>
      <div>1</div>
      <div>2</div>
      <div>3</div>
      <div>4</div>
      <div>5</div>
    </Flex>
  );
};

export const flexDefault = () => {
  const direction = select('direction', ['column', 'row'], 'row');
  const align = select('align', ['left', 'right', 'spaceAround', 'spaceBetween', 'center'], 'left');
  const wrap = boolean('wrap', false);
  const gap = text('gap', '5px');
  const width = text('width', '100%');
  const alignItemCenter = boolean('alignItemCenter', false);
  return (
    <Flex direction={direction} align={align} wrap={wrap} gap={gap} width={width} alignItemCenter={alignItemCenter}>
      <div>아</div>
      <div>이</div>
      <div>앤</div>
      <div>잴</div>
    </Flex>
  );
};

flexDefault.story = {
  name: 'Default'
};
