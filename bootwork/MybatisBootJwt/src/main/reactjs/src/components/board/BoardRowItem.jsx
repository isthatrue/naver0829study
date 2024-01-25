import { Photo } from "@mui/icons-material";
import React from "react";
import { NavLink } from "react-router-dom";

const BoardRowItem = (props) => {
  const { item, idx, no } = props;

  return (
    <tr>
      <td align="center">{no - idx}</td>
      <td>
        <NavLink
          style={{ cursor: "pointer", textDecoration: "none", color: "black" }}
          to={`/board/select/${item.num}`}
        >
          {item.subject}&nbsp;&nbsp;
          {item.photo.length > 0 ? (
            <Photo style={{ width: "20px", height: "20px", color: "#999" }} />
          ) : (
            ""
          )}
        </NavLink>
      </td>
      <td align="center">{item.writer}</td>
      <td align="center">{item.readcount}</td>
      <td align="center">{item.writeday.substring(0, 10)}</td>
    </tr>
  );
};

export default BoardRowItem;
