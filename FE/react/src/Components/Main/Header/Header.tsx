/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Flex from '@Custom/Flex/Flex';
import FilterButton from '@/Custom/FilterButton/FilterButton';
import Button from '@Custom/Button/Button';
import LabelButton from '@Custom/LabelButton/LabelButton';
import TagsInput from '@Custom/TagsInput/TagsInput';

const exampleFilters = [
  'Open Issues',
  'Your Issues',
  'Everything assigned to you',
  'Everything mentioning you',
  'Closed Issues'
];

const Header = () => {
  return (
    <Flex align="spaceAround" customCSS={headerStyle}>
      <Flex align="left">
        <FilterButton
          fontSize="big"
          category="Filters"
          width="100px"
          subject="Filter Issues"
          filters={exampleFilters}
          contentsBoxSize={'100%'}
        />
        <TagsInput tags={['is open:', 'is filtered']} />
      </Flex>
      <Flex align="right">
        <LabelButton iconType="tag" label="Labels" />
        <LabelButton iconType="task" label="MileStones" />
      </Flex>

      <Button width="100px">New Issue</Button>
    </Flex>
  );
};

const headerStyle = css`
  margin-top: 10vh;
  box-sizing: border-box;
  padding: 5rem;
`;

export default Header;
