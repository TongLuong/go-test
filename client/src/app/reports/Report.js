"use client";

import {
    BarChart,
    Bar,
    XAxis,
    YAxis,
    Tooltip,
    Legend,
    ResponsiveContainer,
} from 'recharts';
import React from 'react';

export default function Report() {
    const baseUrl = process.env.NEXT_PUBLIC_API_URL;
    const [levelStats, setLevelStats] = React.useState([]);
    var flag = false;

    React.useEffect(() => {
        async function fetchData() {
            if (flag) {
                return;
            }

            flag = true;
            await fetch(
                baseUrl + `/scores/all`,
                {
                    method: "GET",
                }
            ).then(
                async res => {
                    const data = await res.json();
                    setLevelStats(data);
                }
            ).catch(
                e => console.log(e)
            );
        }
        fetchData();
    }, []);

    return (
        <div className="bg-white p-6 rounded shadow-md">
            <h2 className="text-xl font-bold mb-4 text-black">Score Distribution Report</h2>
            <div className="w-full h-[400px]">
            <ResponsiveContainer width="100%" height="100%">
                <BarChart data={levelStats}>
                <XAxis dataKey="subject" />
                <YAxis allowDecimals={false} />
                <Tooltip />
                <Legend />
                <Bar dataKey="excellent" fill="#4ade80" />
                <Bar dataKey="good" fill="#60a5fa" />
                <Bar dataKey="average" fill="#facc15" />
                <Bar dataKey="belowAverage" fill="#f87171" />
                </BarChart>
            </ResponsiveContainer>
            </div>
        </div>
    );
};