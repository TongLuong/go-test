"use client";
import Sidebar from "../components/Sidebar";
import Header from "../components/Header";
import React from "react";
import axios from "axios";

export default function Home() {
  const [currSbd, setCurrSbd] = React.useState(null);
  const [scores, setScores] = React.useState([
    {
      sbd: "01000001",
      toan: 8.4,
      ngu_van: 6.75,
      ngoai_ngu: 8.0,
      vat_li: 6.0,
      hoa_hoc: 5.25,
      sinh_hoc: 5.0,
      lich_su: "",
      dia_li: "",
      gdcd: "",
      ma_ngoai_ngu: "N1",
    },
  ]);

  const fetchData = async () => {
    await axios({
      method: "get",
      url: `/scores/${commentId}`,
      headers: {
        Authorization: `Bearer ${JWT_loginToken}`,
      },
    });
  };

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col">
      <Header />
      
      <div className="flex-1 flex flex-row overflow-x-auto">
        <Sidebar />

        <div className="flex flex-col grow p-10">
          <div className="py-10 space-y-6 text-black">
            <div className="bg-white p-6 rounded shadow-md">
            <h2 className="text-xl font-bold mb-2">User Registration</h2>
            <label htmlFor="regNumber" className="block mb-2">
              Registration Number:
            </label>
            <div className="flex space-x-2">
              <input
                type="text"
                id="regNumber"
                placeholder="Enter registration number"
                className="border px-4 py-2 w-full rounded"
              />
              <button className="bg-black text-white px-4 py-2 rounded">
                Submit
              </button>
            </div>
            </div>
          </div>

          <div className="bg-white p-6 rounded shadow-md text-black">
            <h2 className="text-xl font-bold mb-4">Detailed Scores</h2>
            <div className="w-full overflow-x-auto">
              <table className="min-w-[900px] w-full text-sm border border-gray-200">
                <thead className="bg-gray-100">
                  <tr>
                    <th className="px-3 py-2 border">SBD</th>
                    <th className="px-3 py-2 border">Toán</th>
                    <th className="px-3 py-2 border">Ngữ Văn</th>
                    <th className="px-3 py-2 border">Ngoại Ngữ</th>
                    <th className="px-3 py-2 border">Vật Lí</th>
                    <th className="px-3 py-2 border">Hóa Học</th>
                    <th className="px-3 py-2 border">Sinh Học</th>
                    <th className="px-3 py-2 border">Lịch Sử</th>
                    <th className="px-3 py-2 border">Địa Lí</th>
                    <th className="px-3 py-2 border">GDCD</th>
                    <th className="px-3 py-2 border">Mã NN</th>
                  </tr>
                </thead>
                <tbody>
                  {scores.map((row, idx) => (
                    <tr key={idx} className="text-center">
                      <td className="px-2 py-1 border">{row.sbd}</td>
                      <td className="px-2 py-1 border">{row.toan || "-"}</td>
                      <td className="px-2 py-1 border">{row.ngu_van || "-"}</td>
                      <td className="px-2 py-1 border">{row.ngoai_ngu || "-"}</td>
                      <td className="px-2 py-1 border">{row.vat_li || "-"}</td>
                      <td className="px-2 py-1 border">{row.hoa_hoc || "-"}</td>
                      <td className="px-2 py-1 border">{row.sinh_hoc || "-"}</td>
                      <td className="px-2 py-1 border">{row.lich_su || "-"}</td>
                      <td className="px-2 py-1 border">{row.dia_li || "-"}</td>
                      <td className="px-2 py-1 border">{row.gdcd || "-"}</td>
                      <td className="px-2 py-1 border">{row.ma_ngoai_ngu || "-"}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}