/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import CommentBoxWithImg from '@Custom/CommentBoxWithImg/CommentBoxWithImg';
import Flex from '@Custom/Flex/Flex';
import Tab from '@Custom/Tab/Tab';
import OptionButton from '@Custom/OptionButton/OptionButton';
import Button from '@Custom/Button/Button';
import Icon from '@Icon/Icon';

const exampleFilters = [
  'Open Issues',
  'Your Issues',
  'Everything assigned to you',
  'Everything mentioning you',
  'Closed Issues'
];

const Detail = () => {
  return (
    <Flex direction="column" gap="1.5rem">
      <Flex direction="column" gap="0.7rem">
        <Flex>
          <Flex>
            <h1 css={h1SizeStyle}>레이블 목록 보기 구현</h1>
            <h1 css={h1SizeStyle}>#1</h1>
          </Flex>
          <Button theme="lightgray" width="5%">
            Edit
          </Button>
        </Flex>
        <Flex align="left" alignItemCenter={true} gap="0.5rem">
          <div css={openStyle}>
            <Button theme="primary">
              <Flex alignItemCenter={true}>
                <Icon icon="exclamation" size="15px" />
                <p>Open</p>
              </Flex>
            </Button>
          </div>
          <Flex align="left">
            <p>sejungkim</p>
            <p>opened this issue</p>
            <p>3 days ago</p>
            <p>1 comment</p>
          </Flex>
        </Flex>
      </Flex>
      <Flex gap="3rem">
        <Flex direction="column" width="100%" gap="1rem" customCSS={boxWrapperStyle}>
          <CommentBoxWithImg />
          <CommentBoxWithImg />
          <Flex direction="column" width="100%">
            <Tab tabs={['Write', 'Preview']} contentsHeight={'200px'} contentsWidth={'100%'} />
            <Flex align="right" gap="1rem">
              <Button theme="lightgray" width="10%">
                <Flex>
                  <Icon icon="exclamation" color="red" size="15px" />
                  <p>Close issue</p>
                </Flex>
              </Button>
              <Button width="7%">Comment</Button>
            </Flex>
          </Flex>
        </Flex>
        <Flex align="left" direction="column" gap="3rem" customCSS={fixedHeightStyle} width="20%">
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
    </Flex>
  );
};

const openStyle = css`
  width: 5%;
`;

const h1SizeStyle = css`
  font-size: 2rem;
`;

const boxWrapperStyle = css`
  border: 1px solid #d1d5da;
  padding: 1rem;
`;

const fixedHeightStyle = css`
  height: 500px;
`;

export default Detail;
