import React from 'react';
import TextInput from './TextInput.js'
import Select from 'react-select';
import 'react-select/dist/react-select.css';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

class CardForm extends React.Component {
    constructor(props) {
        this.state = {
            username: '',
            message: '',
            tags: [],
            dateStamp: undefined

        }

        this.handleSubmit = this.handleSubmit.bind(this)
        this.handleUsernameChange = this.handleUsernameChange.bind(this)
        this.handleMessageChange = this.handleMessageChange.bind(this)
        this.handleTagsChange = this.handleTagsChange.bind(this)
        this.handleDateStampChange = this.handleDateStampChange.bind(this)
    }

    handleUsernameChange(value) {
        this.setState({
            username: value
        })
    }

    handleMessageChange(value) {
        this.setState({
            message: value
        })
    }

    handleSubmit(event) {
        event.preventDefault()
        this.props.onSubmit(this.state.username,
            this.state.message,
            this.state.tags,
            this.state.dateStamp)
    }

    handleTagsChange(tagList) {
        const tagValues = tagList.map(tag => tag.value)
        this.setState({
            tag: tagValues
        })
    }

    handleDateStampChange(dateStamp) {
        this.setState({
            dateStamp: dateStamp
        })
    }


    render() {
        const tagOptions = [
            {
                value: 'today',
                label: 'Today'
            },
            {
                value:'red',
                label:'Red'
            }
        ]

        return (
            <form className='card-form'>
                <h2>Add a Card</h2>
                <TextInput name="username" label="Username" value={this.state.username} onChange={this.handleUsernameChange} />
                <TextInput name="message" label="Message" value= {this.state.message} onChange={this.handleTagsChange}/>
                <Select options={tagOptions} multi value={this.state.tags} onChange={this.handleTagsChange}/>
                <br/>
                
            </form>
        )
    }
}