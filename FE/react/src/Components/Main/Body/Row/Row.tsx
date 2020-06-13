/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Icon from '@Icon/Icon';
import Flex from '@Custom/Flex/Flex';
import Label from '@Custom/Label/Label';

const Row = () => {
  return (
    <tr css={rowStyle}>
      <td css={tdStyle}>
        <input type="checkbox"></input>
      </td>
      <td css={tdStyle}>
        <Icon icon="exclamation" size={'12px'} />
      </td>
      <td css={tdStyle}>
        <Flex direction="column" customCSS={paddingStyle}>
          <Flex align="left" gap={'0.1rem'}>
            <p>[React] issue 목록 페이지 작성</p>
            <Label contents={'FE'} color={'#D93F0B'} />
            <Label contents={'Backend'} color={'#abc123'} />
          </Flex>
          <Flex align="left" gap={'0.04rem'}>
            <p css={footerSytle}>#28</p>
            <p css={footerSytle}>opened</p>
            <p css={footerSytle}>3 hours ago</p>
            <p css={footerSytle}>by sangwon21</p>
          </Flex>
        </Flex>
      </td>
      <td css={tdStyle}>Dolor</td>
      <td css={tdStyle}>Dolor</td>
      <td css={tdStyle}>Dolor</td>
      <td css={tdStyle}>Dolor</td>
      <td css={tdStyle}>Dolor</td>
      <td css={tdStyle}>Dolor</td>
      <td css={tdStyle}>Dolor</td>
    </tr>
  );
};

const rowStyle = css`
  height: 4rem;
`;

const tdStyle = css`
  font-size: 0.9rem;
  text-align: center;
  vertical-align: middle;
`;

const paddingStyle = css`
  padding-left: 0.8rem;
`;

const footerSytle = css`
  font-size: 0.3rem;
`;

export default Row;
