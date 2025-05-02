"use client";
import React from "react";

export default function Score() {
	const baseUrl = process.env.NEXT_PUBLIC_API_URL;

	const [currSbd, setCurrSbd] = React.useState(null);
	const [scores, setScores] = React.useState([]);

	const fetchData = async () => {
		await fetch(
			baseUrl + `/scores/${currSbd}`,
			{
				method: "GET",
			}
		).then(
			async res => {
				const data = await res.json();
				setScores([data]);
			}
		).catch(
			e => console.log(e)
		);
	};

	const handleSubmit = () => {
		fetchData();
	};

	return (
		<div className="flex flex-col grow p-6">
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
				onChange={e => setCurrSbd(e.target.value)}
				/>
				<button
				className="bg-black text-white px-4 py-2 rounded cursor-pointer hover:bg-gray-700 active:bg-gray-500"
				onClick={() => handleSubmit()}
				>
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
					<th className="px-3 py-2 border">Ngữ văn</th>
					<th className="px-3 py-2 border">Ngoại ngữ</th>
					<th className="px-3 py-2 border">Vật lí</th>
					<th className="px-3 py-2 border">Hóa học</th>
					<th className="px-3 py-2 border">Sinh học</th>
					<th className="px-3 py-2 border">Lịch sử</th>
					<th className="px-3 py-2 border">Địa lí</th>
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
	);
};