import React from "react";
import Menu from "./components/Menu";
import { Route, Routes } from "react-router-dom";
import { About, Food, Home } from "./pages";
const RouterMain = () => {
  return (
    <div>
      <Menu />
      <hr style={{ clear: "both" }} />
      <Routes>
        {/* <Route path="/home" element={<Home />} /> */}

        {/* home 에 서브 메뉴를 만들고자 할 경우 */}
        <Route path="/home/*" element={<Home />} />

        {/* <Route path="/about" element={<About />} /> */}
        {/* 파라미터를 보내는 경우 : 방법1 */}
        {/* <Route path="/about/:emp" element={<About />} /> */}

        {/* 파라미터를 보내는 경우 : 방법2 */}
        <Route path="/about/" element={<About />}>
          <Route path=":emp" element={<About />} />
        </Route>

        <Route path="/food" element={<Food />}>
          <Route path=":food1" element={<Food />} />
          <Route path=":food1/:food2" element={<Food />} />
        </Route>

        {/* 그 이외의 매핑주소로 되어 있을 경우 */}
        <Route
          path="*"
          element={
            <div>
              <h1>잘못된 주소입니다.</h1>
              <br />
              <br />
              <img alt="" src={require(`./image/s2.JPG`)} />
            </div>
          }
        />
      </Routes>
    </div>
  );
};

export default RouterMain;
