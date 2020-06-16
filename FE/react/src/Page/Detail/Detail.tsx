/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Detail from '@Components/Detail/Detail';

const DetailPage = () => {
  return (
    <div css={detailStyle}>
      <Detail />
    </div>
  );
};

const detailStyle = css`
  margin-top: 10vh;
  padding: 1rem 3rem;
`;

export default DetailPage;
