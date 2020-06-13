/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Flex from '@Custom/Flex/Flex';
import FilterButton from '@/Custom/FilterButton/FilterButton';
import Button from '@Custom/Button/Button';
import LabelButton from '@Custom/LabelButton/LabelButton';
import Input from '@Custom/Input/Input';
import Icon from '@Icon/Icon';

const exampleFilters = [
  'Open Issues',
  'Your Issues',
  'Everything assigned to you',
  'Everything mentioning you',
  'Closed Issues'
];

const Header = () => {
  return (
    <Flex direction="column" customCSS={headerStyle} gap={'2rem'}>
      <Flex align="spaceBetween">
        <Flex align="left" gap={'0.02rem'}>
          <FilterButton
            theme="lightgray"
            fontSize="big"
            category="Filters"
            width="100px"
            subject="Filter Issues"
            filters={exampleFilters}
            contentsBoxSize={'100%'}
          />
          <Input initalValue={'is open'} width={'400px'} />
        </Flex>
        <Flex align="right" gap={'0.04rem'}>
          <LabelButton iconType="tag" label="Labels" width="120px" />
          <LabelButton iconType="task" label="MileStones" width="120px" />
        </Flex>
        <Button width="100px">New Issue</Button>
      </Flex>
      <Flex align="left" alignItemCenter={true} gap={'0.3rem'}>
        <Icon icon="close" size={'1rem'}></Icon>
        <p>Clear current search query, filters, and sorts</p>
      </Flex>
    </Flex>
  );
};

const headerStyle = css`
  margin-top: 10vh;
  box-sizing: border-box;
  padding: 2rem 12rem;
`;

export default Header;
