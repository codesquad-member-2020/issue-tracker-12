import React from 'react';
import Button from '@Custom/Button/Button';
import { withKnobs, text, boolean, select } from '@storybook/addon-knobs';
import Icon from '@Icon/Icon';
import { action } from '@storybook/addon-actions';

export default {
  title: 'components|Button',
  component: Button,
  decorators: [withKnobs],
  parameters: {
    componentSubtitle: 'Issue Tracker에서 사용할 버튼 컴포넌트'
  }
};

export const primary = () => {
  return <Button onClick={action('primary')}>Button</Button>;
};

export const secondary = () => {
  return (
    <Button theme={'secondary'} fontSize={'medium'} width="50px">
      Button
    </Button>
  );
};

export const nocolor = () => {
  return (
    <Button theme={'nocolor'} fontSize={'big'} width={100}>
      Button
    </Button>
  );
};

export const nooutline = () => {
  return (
    <Button theme={'nooutline'} fontSize={'big'} width={100}>
      Button
    </Button>
  );
};

export const withIcon = () => {
  return (
    <Button theme={'subtle'} width={'50px'} fontSize={'big'}>
      <Icon icon="close" />
    </Button>
  );
};

export const withIconDisabled = () => {
  return (
    <Button theme={'subtle'} width={'50px'} fontSize={'big'} disabled={true}>
      <Icon icon="close" />
    </Button>
  );
};

export const button = () => {
  const label = text('children', 'BUTTON');
  const fontSize = select('fontSize', ['small', 'medium', 'big'], 'medium');
  const theme = select('theme', ['primary', 'secondary', 'nooutline', 'nocolor', 'subtle'], 'primary');
  const disabled = boolean('disabled', false);
  const width = text('width', '100%');
  const noPadding = boolean('noPadding', false);

  return (
    <Button fontSize={fontSize} theme={theme} disabled={disabled} width={width} noPadding={noPadding}>
      {label}
    </Button>
  );
};

button.story = {
  name: 'Default'
};
