"use client";

import React from "react";

export default function Dashboard() {
    const [students, setStudents] = React.useState([]);
    const [top, setTop] = React.useState(10);
    var flag = false;
    const baseUrl = process.env.NEXT_PUBLIC_API_URL;

    React.useEffect(() => {
        async function fetchData() {
            if (flag) {
                return;
            }

            flag = true;
            await fetch(
                baseUrl + `/scores/top?top=${top}`,
                {
                    method: "GET",
                }
            ).then(
                async res => {
                    const data = await res.json();
                    setStudents(data);
                }
            ).catch(
                e => console.log(e)
            );
        }
        fetchData();
    }, []);

    // Helper function to calculate group A score
    const calculateGroupAScore = (student) => {
        const scores = [student.toan, student.vat_li, student.hoa_hoc];
        const validScores = scores.filter((s) => s !== null && s !== undefined && s !== "");
        return validScores.length === 3 ? validScores.reduce((a, b) => a + b, 0) : null;
    };

    // Process and sort top 10
    const topGroupA = students.map((s) => ({
        ...s,
        groupAScore: calculateGroupAScore(s),
    }))
    .filter((s) => s.groupAScore !== null)
    .sort((a, b) => b.groupAScore - a.groupAScore)
    .slice(0, 10);

    return (
        <div className="bg-white p-6 rounded shadow-md text-black">
            <h2 className="text-xl font-bold mb-4">Top 10 Students - Group A (Toán, Vật lí, Hóa học)</h2>
            <div className="overflow-x-auto">
                <table className="min-w-full text-sm border border-gray-200">
                <thead className="bg-gray-100">
                    <tr>
                    <th className="px-4 py-2 border">#</th>
                    <th className="px-4 py-2 border">SBD</th>
                    <th className="px-4 py-2 border">Toán</th>
                    <th className="px-4 py-2 border">Vật lí</th>
                    <th className="px-4 py-2 border">Hóa học</th>
                    <th className="px-4 py-2 border">Tổng điểm</th>
                    </tr>
                </thead>
                <tbody>
                    {topGroupA.map((student, index) => (
                    <tr key={student.sbd} className="text-center">
                        <td className="px-4 py-2 border">{index + 1}</td>
                        <td className="px-4 py-2 border">{student.sbd}</td>
                        <td className="px-4 py-2 border">{student.toan}</td>
                        <td className="px-4 py-2 border">{student.vat_li}</td>
                        <td className="px-4 py-2 border">{student.hoa_hoc}</td>
                        <td className="px-4 py-2 border font-semibold">{student.groupAScore.toFixed(2)}</td>
                    </tr>
                    ))}
                </tbody>
                </table>
            </div>
        </div>
    );
}