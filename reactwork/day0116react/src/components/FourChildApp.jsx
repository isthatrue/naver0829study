import { Button } from "@mui/material";
import React from "react";

function FourChildApp(props) {
  const { name, age, addr } = props;
  return (
    <div className="box">
      {/* {props.name}님의 나이는 {props.age}이며 고향은 {props.addr}입니다. */}
      {name}님의 나이는 {age}이며 고향은 {addr}입니다.
      <Button
        color="info"
        variant="outline"
        style={{ marginLeft: "10px" }}
        onClick={() => {
          props.incre();
        }}
      >
        증가
      </Button>
    </div>
  );
}

export default FourChildApp;
