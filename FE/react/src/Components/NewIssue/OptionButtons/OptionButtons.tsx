/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Flex from '@Custom/Flex/Flex';
import OptionButton from '@Custom/OptionButton/OptionButton';

const exampleFilters = [
  'Open Issues',
  'Your Issues',
  'Everything assigned to you',
  'Everything mentioning you',
  'Closed Issues'
];

const OptionButtons = () => {
  return (
    <Flex direction="column" gap="3rem" width="20%">
      <OptionButton
        contentsBoxSize={'100%'}
        category="Author"
        subject="Filter Issues"
        width={'100%'}
        filters={exampleFilters}
      />
      <OptionButton
        contentsBoxSize={'100%'}
        category="Author"
        subject="Filter Issues"
        width={'100%'}
        filters={exampleFilters}
      />
      <OptionButton
        contentsBoxSize={'100%'}
        category="Author"
        subject="Filter Issues"
        width={'100%'}
        filters={exampleFilters}
      />
    </Flex>
  );
};

export default OptionButtons;
