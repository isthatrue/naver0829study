import React, { useState } from "react";
import c5 from "../images/c5.png";
import s1 from "../images/c1.png";
import s2 from "../images/c2.png";
import s3 from "../images/c3.png";
import s4 from "../images/c4.png";
import s5 from "../images/c5.png";

function FiveApp(props) {
  const [show, setShow] = useState(true);
  const [photo, setPhoto] = useState(s1);
  const [border, setBorder] = useState("inset");
  return (
    <div className="box">
      <h3 className="alert alert-warning">
        FiveApp
        <img alt="" src={c5} style={{ width: "60px", float: "right" }} />
      </h3>
      <div>
        <label>
          <input
            type="checkbox"
            defaultChecked
            onClick={(e) => {
              setShow(e.target.checked);
            }}
          />
          이미지 보이기/숨기기
        </label>
        <br />
        <br />
        <select
          className="form-select"
          style={{ width: "200px" }}
          onChange={(e) => {
            setPhoto(e.target.value);
          }}
        >
          <option value={s1}>영식</option>
          <option value={s2}>영호</option>
          <option value={s3}>옥순</option>
          <option value={s4}>영철</option>
          <option value={s5}>순자</option>
        </select>
        <br />
        <br />
        <select
          className="form-select"
          style={{ width: "200px" }}
          onChange={(e) => {
            setBorder(e.target.value);
          }}
        >
          <option>inset</option>
          <option>dotted</option>
          <option>solid</option>
          <option>dashed</option>
          <option>double</option>
          <option>groove</option>
        </select>
        <br />
        <br />
        {
          // show 값이 true면 이미지가 보이고, false면 안 보인다.
          show && (
            <img alt="" src={photo} style={{ border: `10px ${border} gray` }} />
          )
        }
      </div>
    </div>
  );
}

export default FiveApp;
