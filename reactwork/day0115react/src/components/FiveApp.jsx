import React, { useState } from "react";

function FiveApp(props) {
  const [msg, setMsg] = useState(["Happy", "Hello", "안녕하세요"]);
  return (
    <div>
      <h3 className="alert alert-danger">FiveApp-배열-추가/삭제</h3>
      <input
        type="text"
        className="form-control"
        style={{ width: "200px" }}
        placeholder="단어 입력"
        onKeyUp={(e) => {
          if (e.key === "Enter") {
            // alert(e.target.value);

            // 배열에 push로 일단 추가해보자.
            // setMsg(msg.push(e.target.value));  // 오류 발생

            // React는 배열에 데이터 추가 시 push 말고 concat으로 추가한다.
            setMsg(msg.concat(e.target.value));
            e.target.value = "";
          }
        }}
      />
      <hr />
      <h6 className="alert alert-success">
        총 {msg.length}개의 메세지가 있습니다. - 더블 클릭 시 삭제
      </h6>
      <br />
      {msg.map((m, i) => (
        <h6
          key={i}
          className="select"
          onDoubleClick={(e) => {
            // 방법 1 : slice : 0 ~ i-1 펼침, i+1 ~ 끝까지 펼침
            // setMsg([...msg.slice(0, i), ...msg.slice(i + 1, msg.length)]);

            // 방법 2 : filter
            setMsg(msg.filter((item, idx) => i !== idx));
          }}
        >
          {i + 1} : {m}
        </h6>
      ))}
    </div>
  );
}

export default FiveApp;
