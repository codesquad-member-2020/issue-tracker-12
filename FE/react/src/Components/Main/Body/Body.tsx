/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Icon from '@Icon/Icon';
import Flex from '@Custom/Flex/Flex';
import FilterButton from '@Custom/FilterButton/FilterButton';
import Row from '@Components/Main/Body/Row/Row';

const exampleFilters = [
  'Open Issues',
  'Your Issues',
  'Everything assigned to you',
  'Everything mentioning you',
  'Closed Issues'
];

const Body = () => {
  return (
    <table>
      <thead css={tableHeaderStyle}>
        <tr>
          <th css={centerStyle}>
            <input type="checkbox" />
          </th>
          <th css={centerStyle}>
            <Flex align="center" alignItemCenter={true}>
              <Icon icon="exclamation" size={'13px'} />
            </Flex>
          </th>
          <th css={centerStyle}>
            <Flex align="center" alignItemCenter={true} gap={'0.3rem'}>
              <p>8</p>
              <p>Open</p>
            </Flex>
          </th>
          <th css={centerStyle}>
            <Flex align="center" alignItemCenter={true} gap={'0.3rem'}>
              <Icon icon="check" size={'12px'} />
              <p>10 Closed</p>
            </Flex>
          </th>
          <th css={centerStyle}>
            <FilterButton category="Author" subject="Filter Issues" filters={exampleFilters} contentsBoxSize={'100%'} />
          </th>
          <th css={centerStyle}>
            <FilterButton category="Label" subject="Filter Issues" filters={exampleFilters} contentsBoxSize={'100%'} />
          </th>
          <th css={centerStyle}>
            <FilterButton
              category="Projects"
              subject="Filter Issues"
              filters={exampleFilters}
              contentsBoxSize={'100%'}
            />
          </th>
          <th css={centerStyle}>
            <FilterButton
              category="Milestones"
              subject="Filter Issues"
              filters={exampleFilters}
              contentsBoxSize={'100%'}
            />
          </th>
          <th css={centerStyle}>
            <FilterButton
              category="Assignees"
              subject="Filter Issues"
              filters={exampleFilters}
              contentsBoxSize={'100%'}
            />
          </th>
          <th css={centerStyle}>
            <FilterButton category="Sort" subject="Filter Issues" filters={exampleFilters} contentsBoxSize={'100%'} />
          </th>
        </tr>
      </thead>
      <tbody css={borderStyle}>
        <Row />
        <Row />
        <Row />
      </tbody>
    </table>
  );
};

const tableHeaderStyle = css`
  background-color: #f6f8fa;
  border-left: 1px solid #e1e4e8;
  border-right: 1px solid #e1e4e8;
  border-top: 1px solid #e1e4e8;
`;

const centerStyle = css`
  height: 3rem;
  font-size: 0.9rem;
  text-align: center;
  vertical-align: middle;
`;

const borderStyle = css({
  '> *': {
    borderLeft: '1px solid #e1e4e8',
    borderRight: '1px solid #e1e4e8',
    borderBottom: '1px solid #e1e4e8'
  },
  '> *:first-child': {
    borderTop: '1px solid #e1e4e8'
  }
});

export default Body;
