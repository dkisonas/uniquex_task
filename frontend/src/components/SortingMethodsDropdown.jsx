import React from "react";
import PropTypes from "prop-types";

function SortingMethodsDropdown({ options, setState }) {
  const handleChange = (e) => {
    setState(e.target.value);
    console.log(e.target.value);
    debugger;
  }
  return (
    <div>
      <label
        htmlFor="dropdown"
        className="block text-sm font-medium text-gray-700"
      >
        Sorting Method
      </label>
      <select
        id="dropdown"
        name="dropdown"
        onChange={handleChange}
        className="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm rounded-md"
        defaultValue=""
      >
        <option></option>
        {options && options.map((option, idx) => (
          <option key={idx}>{option}</option>
        ))}
      </select>
    </div>
  );
}

export default SortingMethodsDropdown;

SortingMethodsDropdown.propTypes = {
  options: PropTypes.arrayOf(PropTypes.string),
};
