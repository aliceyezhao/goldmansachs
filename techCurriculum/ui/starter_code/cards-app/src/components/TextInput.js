import React from 'react';

class TextInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = { value: '' };
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    const value = event.target.value;
    this.setState({value: value});
  }

  render() {
    return (
      <div className='form-group'>
        <label className='control-label'>{this.props.label}</label>
        <input type='text' className='form-control' name={this.props.name} value={this.state.value} onChange={this.handleChange} />
      </div>
    )
  }
}

export default TextInput;
