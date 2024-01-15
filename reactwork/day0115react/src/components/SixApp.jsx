import React, { useState } from "react";

function SixApp(props) {
  const [mycar, setMycar] = useState(["2", "7"]);
  const [carno, setCarno] = useState("");
  return (
    <>
      <h3 className="alert alert-warning">SixApp-문제</h3>
      <input
        type="text"
        className="form-control"
        placeholder="자동차 번호 입력 후 엔터"
        style={{ width: "300px" }}
        value={carno}
        onChange={(e) => setCarno(e.target.value)}
        onKeyUp={(e) => {
          if (e.key === "Enter") {
            //1~15가 아니면 경고후 종료
            if (carno < 1 || carno > 12) {
              alert("1~12까지만 입력하세요");
              setCarno("");
              return;
            }
            //...mycar : 기존배열 복사후 펼치고 , carno : 새로운 값 추가
            setMycar([...mycar, carno]);
            //엔터입력 후 인풋벨류 빈칸
            setCarno("");
          }
        }}
      />
      {/* {1-12사이 번호 입력후 엔터를 누르면 해당 자동차 이미지 출력 해당 자동차 이미지에서 더블클릭하면 자동차 삭제하기} */}
      {mycar.map((photo, i) => (
        <img
          alt=""
          key={i}
          style={{ cursor: "pointer" }}
          width="100"
          hspace="10"
          vspace="10"
          src={require(`../images/mycar${photo}.png`)}
          onDoubleClick={() => {
            setMycar([
              ...mycar.slice(0, i),
              ...mycar.slice(i + 1, mycar.length),
            ]);
            alert(`${i} 인덱스 이미지 삭제!!`);
          }}
        />
      ))}
    </>
  );
}

export default SixApp;
