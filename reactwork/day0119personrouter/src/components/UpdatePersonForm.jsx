import { Add, ArtTrack } from "@mui/icons-material";
import { Alert } from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const UpdatePersonForm = () => {
  const [selectData, setSelectData] = useState({});

  const { pnum } = useParams();

  const navi = useNavigate();

  const getSelectData = () => {
    const url = "/person/select?pnum=" + pnum;
    axios.get(url).then((res) => {
      setSelectData(res.data);
    });
  };

  const changeData = (e) => {
    const { name, value } = e.target;
    setSelectData({
      ...selectData,
      [name]: value,
    });
  };

  useEffect(() => {
    getSelectData();
  }, []);

  // 수정 버튼
  const updateDataEvent = () => {
    axios.post("/person/update", selectData).then((res) => {
      // 수정 성공 후 목록으로 이동
      navi(`/detail/${pnum}`);
    });
  };
  return (
    <div className="mainbox">
      <Alert variant="filled" severity="warning">
        Person 수정
      </Alert>
      <div style={{ marginTop: "20px" }}>
        <table className="table table-bordered">
          <tbody>
            <tr>
              <th style={{ width: "100px", backgroundColor: "#ccc" }}>이름</th>
              <td>
                <input
                  type="text"
                  value={selectData.name}
                  name="name"
                  style={{ width: "150px" }}
                  className="form-control"
                  onChange={changeData}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "100px", backgroundColor: "#ccc" }}>나이</th>
              <td>
                <input
                  type="text"
                  style={{ width: "150px" }}
                  className="form-control"
                  value={selectData.age}
                  name="age"
                  onChange={changeData}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "100px", backgroundColor: "#ccc" }}>
                혈액형
              </th>
              <td>
                <select
                  className="form-select"
                  style={{ width: "150px" }}
                  value={selectData.blood}
                  name="blood"
                  onChange={changeData}
                >
                  <option>A</option>
                  <option>B</option>
                  <option>O</option>
                  <option>AB</option>
                </select>
              </td>
            </tr>
            <tr>
              <th style={{ width: "100px", backgroundColor: "#ccc" }}>사진</th>
              <td className="input-group">
                {selectData.photo && (
                  <img
                    alt=""
                    src={require(`../images/${selectData.photo}`)}
                    style={{ width: "80px", marginRight: "10px" }}
                  />
                )}
                <select
                  className="form-select"
                  style={{ width: "150px", height: "40px" }}
                  name="photo"
                  value={selectData.photo}
                  onChange={changeData}
                >
                  {[...new Array(5)].map((a, idx) => (
                    <option>{idx + 1}.png</option>
                  ))}
                </select>
              </td>
            </tr>
            <tr>
              <td colSpan={2} align="center">
                <button
                  className="btn btn-outline-secondary"
                  onClick={updateDataEvent}
                >
                  <Add />
                  <span style={{ marginLeft: "10px" }}>수정</span>
                </button>

                <button
                  className="btn btn-outline-secondary"
                  style={{ marginLeft: "10px" }}
                  onClick={() => navi("/")}
                >
                  <ArtTrack />
                  <span style={{ marginLeft: "10px" }}>목록</span>
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UpdatePersonForm;
