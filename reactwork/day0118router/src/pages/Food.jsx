import { Alert } from "@mui/material";
import React from "react";
import { useParams } from "react-router-dom";

const Food = () => {
  const { food1, food2 } = useParams();

  return (
    <div>
      <Alert variant="filled" severity="warning">
        About 컴포넌트입니다.
      </Alert>
      {/* // emp 값이 넘어오지 않은 경우 실행할 영역 */}

      {food1 == null ? (
        <div>
          <h1>저는 오늘 굶겠습니다.</h1>
        </div>
      ) : food2 == null ? (
        <div>
          <h1>후식은 안 먹겠습니다.</h1>
          <img alt="" src={require(`../image/${food1}.jpg`)} />
        </div>
      ) : (
        <div>
          <h1>꺼-억</h1>
          <img alt="" src={require(`../image/${food1}.jpg`)} />
          <img alt="" src={require(`../image/${food2}.jpg`)} />
        </div>
      )}
    </div>
  );
};

export default Food;
