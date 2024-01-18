import React from "react";
import { Alert } from "@mui/material";
import { useParams } from "react-router-dom";
import simg from "../image/s1.JPG";
import gimg from "../image/s10.JPG";

const About = () => {
  const { emp } = useParams();
  console.log({ emp }); // {"emp": "Samsung"}
  console.log({ emp }.emp); // Samsung
  return (
    <div>
      <Alert variant="filled" severity="warning">
        About 컴포넌트입니다.
      </Alert>
      {
        // emp 값이 넘어오지 않은 경우 실행할 영역
        emp == null ? (
          <div>
            <h1>저는 취업 준비생 입니다.</h1>
            <img alt="" src={require(`../image/s6.JPG`)} />
          </div>
        ) : (
          // emp 값이 있는 경우 실행할 영역
          <div>
            <img alt="" src={emp === "Samsung" ? simg : gimg} />
          </div>
        )
      }
    </div>
  );
};

export default About;
