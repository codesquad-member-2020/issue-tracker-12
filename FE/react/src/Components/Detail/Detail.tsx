/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import CommentBoxWithImg from '@Custom/CommentBoxWithImg/CommentBoxWithImg';
import Flex from '@Custom/Flex/Flex';
import Tab from '@Custom/Tab/Tab';
import OptionButton from '@Custom/FilterButton/FilterButton';
import Button from '@Custom/Button/Button';

const exampleFilters = [
  'Open Issues',
  'Your Issues',
  'Everything assigned to you',
  'Everything mentioning you',
  'Closed Issues'
];

const Detail = () => {
  return (
    <Flex>
      <Flex direction="column" width="100%">
        <CommentBoxWithImg />
        <CommentBoxWithImg />
        <Flex direction="column" width="100%">
          <Tab tabs={['Write', 'Preview']} contentsHeight={'200px'} contentsWidth={'100%'} />
          <Flex align="right" gap="1rem">
            <Button width="7%">Close issue</Button>
            <Button width="7%">Comment</Button>
          </Flex>
        </Flex>
      </Flex>
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
    </Flex>
  );
};

export default Detail;
