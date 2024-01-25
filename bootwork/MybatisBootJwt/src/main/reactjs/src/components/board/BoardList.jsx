import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import BoardRowItem from "./BoardRowItem";

const BoardList = () => {
  const [data, setData] = useState({}); // 서버에서 보낸 리스트 및 페이지 출력에 필요한 모든 데이터들
  const [search, setSearch] = useState("");

  const navi = useNavigate();
  const { currentPage } = useParams();
  console.log(currentPage); // 값이 없으면 undefined(null)

  // 처음 시작 시 1페이지 목록 가져온다.
  const boardList = () => {
    const url =
      "/board/list?currentPage=" +
      (currentPage == null ? 1 : currentPage) +
      "&search=" +
      search;
    axios.get(url).then((res) => {
      console.log(res.data);
      setData(res.data);
      console.log(res.data.list);
    });
  };

  // useEffect(() => {
  //     console.log('boardList useEffect 1');
  //     boardList();
  // }, []); // 처음 시작 시 한번만 실행

  useEffect(() => {
    console.log("boardList useEffect #2!");
    boardList();
  }, [currentPage, search]); // 페이지 or 검색어가 바뀌면 useEffect 실행

  return (
    <div>
      <h4 className="window-bar">
        게시판목록
        {sessionStorage.token && (
          <button
            type="button"
            className="btn btn-danger"
            onClick={() => navi("/board/form")}
            style={{ float: "right" }}
          >
            글쓰기
          </button>
        )}
      </h4>
      <div className="input-group" style={{ width: "300px", float: "right" }}>
        <input
          type="text"
          className="form-control"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          placeholder="검색할 제목을 입력해주세요"
        />
        &nbsp;
        <button
          type="button"
          className="btn btn-success btn-sm"
          onClick={() => {
            // 검색 버튼 클릭 시 currentPage를 1로 설정하여 검색 결과가 첫 페이지에서 시작하도록 함
            const url = `/board/list?currentPage=1&search=${search}`;
            axios.get(url).then((res) => {
              setData(res.data);
            });
          }}
        >
          검색
        </button>
      </div>
      <br />
      <br />
      <table
        className="table table-bordered"
        style={{ width: "700px", fontSize: "20px" }}
      >
        <thead>
          <tr>
            <th style={{ width: "60px", backgroundColor: "#ddd" }}>번호</th>
            <th style={{ width: "350px", backgroundColor: "#ddd" }}>제목</th>
            <th style={{ width: "100px", backgroundColor: "#ddd" }}>작성자</th>
            <th style={{ width: "60px", backgroundColor: "#ddd" }}>조회</th>
            <th style={{ width: "130px", backgroundColor: "#ddd" }}>작성일</th>
          </tr>
        </thead>
        <tbody>
          {data.list &&
            data.list.map((item, idx) => (
              <BoardRowItem key={idx} item={item} idx={idx} no={data.no} />
            ))}
        </tbody>
      </table>
      <div style={{ width: "700px", textAlign: "center" }}>
        {/* 이전으로 이동 */}
        {data.startPage > 1 ? (
          <Link to={"/board/list/" + (data.startPage - 1)} className="pagenum">
            <b style={{ color: "black" }}>이전</b>
          </Link>
        ) : (
          ""
        )}
        {data.parr &&
          data.parr.map((item, idx) => (
            <Link to={"/board/list/" + item} className="pagenum" key={idx}>
              <b style={{ color: item == currentPage ? "red" : "black" }}>
                {item}
              </b>
            </Link>
          ))}
        {/* 다음으로 이동 */}
        {data.endPage < data.totalPage ? (
          <Link to={"/board/list/" + (data.endPage + 1)} className="pagenum">
            <b style={{ color: "black" }}>다음</b>
          </Link>
        ) : (
          ""
        )}
      </div>
    </div>
  );
};

export default BoardList;
