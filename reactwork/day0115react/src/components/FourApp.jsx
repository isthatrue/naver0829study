import React from "react";
import img1 from "../images/K-036.png";
import img2 from "../images/K-039.png";
import img3 from "../images/K-041.png";
import img4 from "../images/K-049.png";
import "./MyStyle.css";

function FourApp(props) {
  // 4개의 import 된 이미지를 배열에 저장
  const myImage = [img1, img2, img3, img4];
  const data = [
    { name: "강호동", addr: "서울", hp: "010-2222-3333", photo: "c1" },
    { name: "이미자", addr: "부산", hp: "010-4545-5656", photo: "c3" },
    { name: "손호준", addr: "제주도", hp: "010-7878-9090", photo: "c5" },
    { name: "배미숙", addr: "경기도", hp: "010-4678-9876", photo: "c7" },
  ];
  return (
    <div>
      <h3 className="alert alert-info">FourApp-map으로 이미지 배열 출력</h3>
      {myImage.map((img, idx) => (
        <img alt="" src={img} width={200} />
      ))}
      <hr />
      {data.map((ele, i) => (
        <div className="box">
          <h5>이름 : {ele.name}</h5>
          <h5>주소 : {ele.addr}</h5>
          <h5>핸드폰 : {ele.hp}</h5>
          <img
            alt="프로필 사진"
            width={120}
            src={require(`../images/${ele.photo}.png`)}
          />
        </div>
      ))}
      <hr />
      <table className="table table-bordered" style={{ width: "500px" }}>
        <thead>
          <tr>
            <th width="50">번호</th>
            <th width="100">사진</th>
            <th width="100">이름</th>
            <th width="150">핸드폰</th>
            <th>주소</th>
          </tr>
        </thead>
        <tbody>
          {data.map((ele, i) => (
            <tr key={i}>
              <td>{i + 1}</td>
              <td>
                <img
                  alt=""
                  src={require(`../images/${ele.photo}.png`)}
                  width={80}
                />
              </td>
              <td>{ele.name}</td>
              <td>{ele.hp}</td>
              <td>{ele.addr}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default FourApp;
