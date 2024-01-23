import React from "react";
import mainImage1 from "../image/K-041.png";
import mainImage2 from "../image/K-053.png";

const Home = () => {
  return (
    <>
      <h1>React+SpringBoot 프로젝트</h1>
      <img
        alt=""
        src={mainImage1}
        width={"300px"}
        style={{ margin: "10px", border: "5px groove orange" }}
      />
      <img
        alt=""
        src={mainImage2}
        width={"300px"}
        style={{ margin: "10px", border: "5px groove orange" }}
      />
    </>
  );
};

export default Home;
