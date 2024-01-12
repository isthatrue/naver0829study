import React, { useState } from "react";
import c4 from "../images/c4.png";
function FourApp(props) {
  const [fname, setFname] = useState("Single Day");
  const [fsize, setFsize] = useState("20px");
  const [fcolor, setFcolor] = useState("blue");

  // 이벤트들
  // 글자색 변경하는 이벤트
  const changeFontColor = (e) => {
    setFcolor(e.target.value);
  };

  const changeFontSize = (e) => {
    setFsize(e.target.value);
  };

  const changeFontName = (e) => {
    setFname(e.target.value);
  };

  return (
    <div className="box">
      <h3 className="alert alert-danger">
        FourApp
        <img alt="" src={c4} style={{ width: "60px", float: "right" }} />
      </h3>
      <div style={{ fontFamily: fname, fontSize: fsize, color: fcolor }}>
        오늘은 즐거운 금요일!!
      </div>
      <div style={{ marginTop: "10px" }}>
        <label>
          <input
            type="radio"
            name="fcolor"
            defaultValue={"red"}
            onClick={changeFontColor}
          />
          빨강
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fcolor"
            defaultValue={"blue"}
            defaultChecked
            onClick={changeFontColor}
          />
          파랑
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fcolor"
            defaultValue={"green"}
            onClick={changeFontColor}
          />
          초록
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fcolor"
            defaultValue={"magenta"}
            onClick={changeFontColor}
          />
          분홍
        </label>
      </div>

      <div style={{ marginTop: "10px" }}>
        <label>
          <input
            type="radio"
            name="fname"
            defaultValue={"Gamja Flower"}
            onClick={changeFontName}
          />
          Gamja Flower
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fname"
            defaultValue={"Single Day"}
            defaultChecked
            onClick={changeFontName}
          />
          Single Day
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fname"
            defaultValue={"Jua"}
            onClick={changeFontName}
          />
          Jua
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fname"
            defaultValue={"Nanum Pen Script"}
            onClick={changeFontName}
          />
          Nanum Pen Script
        </label>
      </div>

      <div style={{ marginTop: "10px" }}>
        <label>
          <input
            type="radio"
            name="fsize"
            defaultValue={"13px"}
            onClick={changeFontSize}
          />
          아주 작게
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fsize"
            defaultValue={"20px"}
            defaultChecked
            onClick={changeFontSize}
          />
          작게
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fsize"
            defaultValue={"30px"}
            onClick={changeFontSize}
          />
          크게
        </label>
        <label style={{ marginLeft: "10px" }}>
          <input
            type="radio"
            name="fsize"
            defaultValue={"40px"}
            onClick={changeFontSize}
          />
          아주 크게
        </label>
      </div>
    </div>
  );
}
export default FourApp;
