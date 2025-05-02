"use client";
import Sidebar from "./components/Sidebar";
import Header from "./components/Header";
import React from "react";
import Score from "./scores/Score";
import Report from "./reports/Report";
import Dashboard from "./dashboard/Dashboard";

export default function Home() {
    const [currTab, setCurrTab] = React.useState(1);

    const getMain = (index) => {
        if (index === 0) {
            return <Dashboard/>;
        }
        else if (index === 1) {
            return <Score/>;
        }
        else if (index === 2) {
            return <Report/>;
        }
        return null;
    };

    return (
    <div className="min-h-screen bg-gray-100 flex flex-col">
        <Header />
        
        <div className="flex-1 flex flex-row overflow-x-auto">
            <Sidebar
                currTab={currTab}
                setCurrTab={setCurrTab}
            />

            <div className="flex flex-col grow">
                {getMain(currTab)}
            </div>
        </div>
    </div>
    );
};